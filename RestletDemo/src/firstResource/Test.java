package firstResource;

import java.io.IOException;

import org.restlet.Client;
import org.restlet.data.Form;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.data.Response;
import org.restlet.resource.Representation;

public class Test {

    public static void main(String[] args) throws IOException {
        // Define our Restlet HTTP client.
        Client client = new Client(Protocol.HTTP);

        // The URI of the resource "list of items".
        Reference itemsUri = new Reference("http://localhost:8080/RestletDemo/items");
        Reference itemUri = new Reference("http://localhost:8080/RestletDemo/items/item1");
        Item item = new Item("项目1", "描述1.");

        // 创建item
        Reference newly = createItem(item, client, itemsUri);
        System.out.println(newly);
        if (newly != null) {
            // 获取新创建的item
            get(client, newly);
        }

        // 获取item列表
        get(client, itemsUri);

        // 更新item
        item.setDescription("This is an other description");
        updateItem(item, client, itemUri);

        // 获取item列表
        get(client, itemsUri);

        // 删除item
        deleteItem(client, itemUri);

        // 获取item列表
        get(client, itemsUri);
    }

    /**
     * Try to create a new item.
     * 
     * @param item the new item.
     * @param client the Restlet HTTP client.
     * @param itemsUri where to POST the data.
     * @return the Reference of the new resource if the creation succeeds, null otherwise.
     */
    public static Reference createItem(Item item, Client client, Reference itemsUri) {
        // Gathering informations into a Web form.
        Form form = new Form();
        form.add("name", item.getName());
        form.add("description", item.getDescription());
        Representation rep = form.getWebRepresentation();

        // Launch the request
        Response response = client.post(itemsUri, rep);
        if (response.getStatus().isSuccess()) {
            return response.getEntity().getIdentifier();
        }

        return null;
    }

    /**
     * Prints the resource's representation.
     * 
     * @param client client Restlet.
     * @param reference the resource's URI.
     * @throws IOException
     */
    public static void get(Client client, Reference reference) throws IOException {
        Response response = client.get(reference);
        if (response.getStatus().isSuccess()) {
            if (response.isEntityAvailable()) {
                response.getEntity().write(System.out);
            }
        }
    }

    /**
     * Try to update an item.
     * 
     * @param item the item.
     * @param client the Restlet HTTP client.
     * @param itemUri the resource's URI.
     */
    public static boolean updateItem(Item item, Client client, Reference itemUri) {
        // Gathering informations into a Web form.
        Form form = new Form();
        form.add("name", item.getName());
        form.add("description", item.getDescription());
        Representation rep = form.getWebRepresentation();

        // Launch the request
        Response response = client.put(itemUri, rep);
        return response.getStatus().isSuccess();
    }

    /**
     * Try to delete an item.
     * 
     * @param client the Restlet HTTP client.
     * @param itemUri the resource's URI.
     */
    public static boolean deleteItem(Client client, Reference itemUri) {
        // Launch the request
        Response response = client.delete(itemUri);
        return response.getStatus().isSuccess();
    }

}
