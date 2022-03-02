package daniel.nofulla.customsearchenginebackend.history;

import daniel.nofulla.customsearchenginebackend.repositories.UserRepository;
import daniel.nofulla.customsearchenginebackend.entities.SearchHistory;
import daniel.nofulla.customsearchenginebackend.entities.User;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SearchHistoryService implements SearchHistoryServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
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

        User userToReturn = findUserByIpAddress(searchHistoryAddOneRequest.getIpAddress());
        ArrayList<SearchHistory> searchHistoryToEdit = (ArrayList<SearchHistory>) userToReturn.getSearchHistory();
        searchHistoryToEdit.add(new SearchHistory(searchHistoryAddOneRequest.getQuery(), userToReturn));
        userToReturn.setSearchHistory(searchHistoryToEdit);
        userRepository.save(userToReturn);

        Map map = new HashMap();
        map.put("user", userToReturn);
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
        for (User user : (ArrayList<User>) userRepository.findAll()) {
            if (user.getIpAddress().equals(ipAddress)) {
                return user;
            }
        }
        return null;
    }
}
