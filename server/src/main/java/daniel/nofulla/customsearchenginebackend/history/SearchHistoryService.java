package daniel.nofulla.customsearchenginebackend.history;

import daniel.nofulla.customsearchenginebackend.repositories.UserRepository;
import daniel.nofulla.customsearchenginebackend.entities.SearchHistory;
import daniel.nofulla.customsearchenginebackend.entities.User;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchHistoryService implements SearchHistoryServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getUserSearchHistory(SearchHistoryGetAllRequest searchHistoryGetAllRequest) {
        User user = new User(searchHistoryGetAllRequest.getIpAddress());
        User userExists = findUserByIpAddress(searchHistoryGetAllRequest.getIpAddress());

        if (userExists != null) {
            return ResponseEntity.ok().body(new JSONObject().appendField("user", userExists));
        } else {
            userRepository.save(user);
            return ResponseEntity.ok().body(new JSONObject().appendField("user", user));
        }
    }

    public ResponseEntity<?> addOneSearchHistory(SearchHistoryAddOneRequest searchHistoryAddOneRequest) {
        System.out.println("Started addOneSearchHistory");
        System.out.println("IP: " + searchHistoryAddOneRequest.getIpAddress());
        System.out.println("Query: " + searchHistoryAddOneRequest.getQuery());

        User userToReturn = new User();
        userToReturn = findUserByIpAddress(searchHistoryAddOneRequest.getIpAddress());

        System.out.println("Got user by ip address");

        List<SearchHistory> searchHistoryToEdit = new ArrayList<SearchHistory>();
        System.out.println(userToReturn);
        searchHistoryToEdit.addAll(userToReturn.getSearchHistory());
        System.out.println("Created arraylist of search histories");


        searchHistoryToEdit.add(new SearchHistory(searchHistoryAddOneRequest.getQuery(), userToReturn));

        System.out.println("Added Search History Record");


        userToReturn.setSearchHistory(searchHistoryToEdit);
        System.out.println("Set new search history");

        userRepository.save(userToReturn);
        System.out.println("Saved new user w/ updated search history");

        Map map = new HashMap();
        map.put("user", userToReturn);
        System.out.println("Sending back new User with updated search history");
        return ResponseEntity.ok().body(new JSONObject(map));
    }


    public ResponseEntity<?> deleteOneSearchHistory(SearchHistoryDeleteOneRequest searchHistoryDeleteOneRequest) {
        User userToReturn = findUserByIpAddress(searchHistoryDeleteOneRequest.getIpAddress());
        ArrayList<SearchHistory> searchHistoryToEdit = (ArrayList<SearchHistory>) userToReturn.getSearchHistory();

        for (int i = 0; i < searchHistoryToEdit.size(); i++) {
            if (searchHistoryToEdit.get(i).getId() == searchHistoryDeleteOneRequest.getId()) {
                searchHistoryToEdit.remove(searchHistoryToEdit.get(i));
            }
            userToReturn.setSearchHistory(searchHistoryToEdit);
        }

        userRepository.save(userToReturn);

        Map map = new HashMap();
        map.put("user", userToReturn);
        return ResponseEntity.ok().body(new JSONObject(map));
    }


    public ResponseEntity<?> deleteAllSearchHistory(SearchHistoryDeleteAllRequest searchHistoryDeleteAllRequest) {
        User userToReturn = findUserByIpAddress(searchHistoryDeleteAllRequest.getIpAddress());

        userToReturn.setSearchHistory(new ArrayList<SearchHistory>());

        userRepository.save(userToReturn);

        Map map = new HashMap();
        map.put("user", userToReturn);
        return ResponseEntity.ok().body(new JSONObject(map));
    }

    public User findUserByIpAddress(String ipAddress) {
        for (User user : userRepository.findAll()) {
            if (user.getIpAddress().equals(ipAddress)) {
                return user;
            }
        }
        return null;
    }
}
