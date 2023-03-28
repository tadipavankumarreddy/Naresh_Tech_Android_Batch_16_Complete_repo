
package in.nareshtech.newsdirect;

import java.util.List;

public class Source {

    private String category;
    private List<Datum> data;
    private boolean success;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param data
     * @param success
     * @param category
     */
    public Source(String category, List<Datum> data, boolean success) {
        super();
        this.category = category;
        this.data = data;
        this.success = success;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
