
package in.nareshtech.networkingwithretrofit;

import java.util.List;

public class Source {

    private List<Object> categories;
    private String createdAt;
    private String iconUrl;
    private String id;
    private String updatedAt;
    private String url;
    private String value;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param createdAt
     * @param categories
     * @param iconUrl
     * @param id
     * @param value
     * @param url
     * @param updatedAt
     */
    public Source(List<Object> categories, String createdAt, String iconUrl, String id, String updatedAt, String url, String value) {
        super();
        this.categories = categories;
        this.createdAt = createdAt;
        this.iconUrl = iconUrl;
        this.id = id;
        this.updatedAt = updatedAt;
        this.url = url;
        this.value = value;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
