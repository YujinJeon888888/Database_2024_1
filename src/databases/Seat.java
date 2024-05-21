package databases;

public class Seat {
    private String seatNo;
    private String areaCode;
    private String seatRow;
    private String seatCol;

    // Default constructor
    public Seat() {}

    // Parameterized constructor
    public Seat(String seatNo, String areaCode, String seatRow, String seatCol) {
        this.seatNo = seatNo;
        this.areaCode = areaCode;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
    }

    // Getters and Setters
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(seatNo).append(" \t | ").append(areaCode).append(" \t | ")
                .append(seatRow).append(" \t | ").append(seatCol);
        return builder.toString();
    }
}
