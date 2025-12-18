package model;


public class Manufactures {
    private Long id;
    private String name;
    private String country;
    private String logoUrl;
    private Integer employeeCount;
    private String shortDescription;

    public Manufactures() {}


    public Manufactures(Long id, String name, String country, String logoUrl,
                        Integer employeeCount, String shortDescription) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.logoUrl = logoUrl;
        this.employeeCount = employeeCount;
        this.shortDescription = shortDescription;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public Integer getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(Integer employeeCount) { this.employeeCount = employeeCount; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
}