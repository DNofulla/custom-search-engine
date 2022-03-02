package daniel.nofulla.customsearchenginebackend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ipAddress")
    private String ipAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SearchHistory> searchHistory;

    public User() {

    }

    public User(String ipAddress) {
        this.ipAddress = ipAddress;
        this.searchHistory = new ArrayList<SearchHistory>();
    }

    public User(int id, String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.searchHistory = new ArrayList<SearchHistory>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<SearchHistory> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(ArrayList<SearchHistory> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public boolean equals(User user) {
        if (user.getIpAddress().equals(ipAddress)) {
            return true;
        } else {
            return false;
        }
    }
}
