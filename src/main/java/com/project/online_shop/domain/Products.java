package com.project.online_shop.domain;

import com.fasterxml.jackson.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "product_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "image", length = 50)
    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    @Transient
    private MultipartFile upload;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer")
    private Manufacturers manufacturer;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "accessible")
    private Boolean accessible;

    @OneToMany(mappedBy = "product_id", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Products_properties> productsProperties;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Categories> categories;

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public Set<Products_properties> getProductsProperties() {
        return productsProperties;
    }

    public void setProductsProperties(Set<Products_properties> productsProperties) {
        this.productsProperties = productsProperties;
    }

    public Products() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public MultipartFile getUpload() {
        return upload;
    }

    public void setUpload(MultipartFile upload) {
        this.upload = upload;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Manufacturers getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturers manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public Boolean getAccessible() {
        return accessible;
    }

    public void setAccessible(Boolean accessible) {
        this.accessible = accessible;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", manufacturer=" + manufacturer +
                ", short_description='" + short_description + '\'' +
                ", accessible=" + accessible +
                '}';
    }
}
