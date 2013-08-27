public class Main {

    static class BoardSpliter {
        static String[] splits(String board) {
            return new String[] {
                    "" + board.charAt(0) + board.charAt(1) + board.charAt(2),
                    "" + board.charAt(3) + board.charAt(4) + board.charAt(5),
                    "" + board.charAt(6) + board.charAt(7) + board.charAt(8),
                    "" +    board.charAt(0) + board.charAt(3) + board.charAt(6),
                    "" +    board.charAt(1) + board.charAt(4) + board.charAt(7),
                    "" +    board.charAt(2) + board.charAt(5) + board.charAt(8),
                    "" +    board.charAt(0) + board.charAt(4) + board.charAt(8),
                    "" +   board.charAt(2) + board.charAt(4) + board.charAt(6)
            }                                                                 ;
        }
    }

    static class CurrentPlayerCalculator {
        static String currentPlayer(String board) {
            String boardWithNoEmptyCells = board.replaceAll("-","");
            int nought = boardWithNoEmptyCells.replaceAll("x", "").length();
            int cross = boardWithNoEmptyCells.replaceAll("0", "").length();

            return (nought == cross) ? "0" : "x";
        }
    }

    interface Strategy {
        int nextCell(String board);
    }

    static class FirstEmptyCellStrategy implements Strategy {
        public int nextCell(String board) {
            return board.indexOf("-");
        }
    }

    static class BlockingNoughtStrategy implements Strategy {
        public int nextCell(String board) {
            int blockingCellIndex = board.indexOf("0-0");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 1;
            }
            return -1;
        }
    }

    static class WinNoughtStrategy implements Strategy {


        public int nextCell(String board) {
            int blockingCellIndex = board.indexOf("0-0");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 1;
            }
            blockingCellIndex = board.indexOf("00-");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 2;
            }
            return -1;
        }
    }

    static class BlockingCrossStrategy implements Strategy {
        public int nextCell(String board) {
            int blockingCellIndex = board.indexOf("x-x");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 1;
            }
            return -1;
        }
    }

    static class WinCrossStrategy implements Strategy {
        public int nextCell(String board) {
            int blockingCellIndex = board.indexOf("x-x");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 1;
            }
            blockingCellIndex = board.indexOf("xx-");
            if (blockingCellIndex != -1) {
                return blockingCellIndex + 2;
            }
            return -1;
        }
    }

    static class MiddleStrategy implements Strategy {
        public int nextCell(String board) {
            return (board.charAt(4) == '-') ? 4 : -1;
        }
    }

    static class CornerStrategy implements Strategy {
        int corners[] = {0,2,6,8};


        public int nextCell(String board) {
            for (int corner: corners) {
                if (board.charAt(corner) == '-') {
                    return corner;
                }
            }

            return -1;
        }
    }

    static Strategy[] naughtStrategies = new Strategy[] {
            new WinNoughtStrategy(),
            new BlockingCrossStrategy(),
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    };

    static Strategy[] crossStrategies = new Strategy[] {
            new WinCrossStrategy(),
            new BlockingNoughtStrategy(),
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    };

    public static class Robot {


        public int execute(String board) {
            Strategy[] strategies = (CurrentPlayerCalculator.currentPlayer(board).equals("0"))
                        ? naughtStrategies : crossStrategies;

            int result = -1;
            for (Strategy strategy : strategies) {
                result = strategy.nextCell(board);
                if (result != -1) {
                    break;
                }
            }
            return result;
        }
    }

	public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.execute(args[0]));
	}
}