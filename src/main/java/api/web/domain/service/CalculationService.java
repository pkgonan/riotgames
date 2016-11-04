package api.web.domain.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    final static double POSITIVE_ZERO = 0.000000;
    final static double NEGATIVE_ZERO = -0.000000;

    public String calculate(String expression) {
        try {
            double nonConvertedFormatData = evaluateExpression(expression);
            String convertedFormatData = convertFormat(nonConvertedFormatData);

            return convertedFormatData;
        } catch (Exception e) {
            return "ERROR";
        }
    }

    private String convertFormat(double nonConvertedFormatData) {
        return String.format("%.6f", nonConvertedFormatData);
    }

    private double evaluateExpression(final String str) throws Exception {
        return new Object() {
            int pos = -1, ch;

            void nextChar() { ch = (++pos < str.length()) ? str.charAt(pos) : -1; }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                if (str.equals("pi")) return Math.PI;
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException();
                if (x == Double.POSITIVE_INFINITY) throw new ArithmeticException();
                if (x == NEGATIVE_ZERO) x = POSITIVE_ZERO;
                return x;
            }

            // BNF & Parser Tree
            // Grammar :
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number | functionName factor | factor `^` factor
            double parseExpression() {
                double x = parseTerm();
                while(true) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                while(true) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) throw new RuntimeException(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions ex) e
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (func.equals("e")) x = Math.E;
                    else throw new RuntimeException();
                } else throw new RuntimeException();

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}