package exo1;

import org.json.JSONObject;
public class JsonFormatter implements ContactFormatter {
    @Override
    public String formatContact(Contact contact) {
        JSONObject json = new JSONObject();
        json.put("name", contact.getName());
        json.put("phonenumber", contact.getPhoneNumber());
        return json.toString();
    }
}
