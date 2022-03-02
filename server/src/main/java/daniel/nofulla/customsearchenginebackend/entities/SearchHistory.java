package daniel.nofulla.customsearchenginebackend.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "searches")
public class SearchHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String searchQuery;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public SearchHistory() {

    }

    public SearchHistory(String searchQuery, User user){
        this.searchQuery = searchQuery;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(SearchHistory searchHistory) {
        if (searchHistory.getId() == id) {
            return true;
        } else {
            return false;
        }
    }
}
