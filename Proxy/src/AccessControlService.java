import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, String> accessControlMap;

    private AccessControlService() {
        accessControlMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        accessControlMap.put(documentId, username);
    }

    public boolean isAllowed(String documentId, String username) {
        String allowedUser = accessControlMap.get(documentId);
        return allowedUser != null && allowedUser.equals(username);
    }
}
