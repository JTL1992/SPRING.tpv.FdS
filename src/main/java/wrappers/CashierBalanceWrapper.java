package wrappers;

public class CashierBalanceWrapper {

    private int id;

    private double change;

    private double total;

    private double checks;

    private double dataphone;

    private String date;

    public static final String dateFormat = "dd-MM-yyyy";

    public CashierBalanceWrapper(int id, double change, double total, double checks, double dataphone, String date) {
        super();
        this.id = id;
        this.change = change;
        this.total = total;
        this.checks = checks;
        this.dataphone = dataphone;
        this.date = date;
    }

    public CashierBalanceWrapper(double change, double total, double checks, double dataphone, String date) {
        super();
        this.change = change;
        this.total = total;
        this.checks = checks;
        this.dataphone = dataphone;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getChecks() {
        return checks;
    }

    public void setChecks(double checks) {
        this.checks = checks;
    }

    public double getDataphone() {
        return dataphone;
    }

    public void setDataphone(double dataphone) {
        this.dataphone = dataphone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CashierBalanceWrapper {id=" + id + ", change=" + change + ", total=" + total + ", checks=" + checks + ", dataphone="
                + dataphone + ", date=" + date + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CashierBalanceWrapper other = (CashierBalanceWrapper) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

}
