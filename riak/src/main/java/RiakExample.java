import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;

import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class RiakExample {

    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {

        RiakClient client = RiakClient.newClient(8087, "127.0.0.1");

        Location location = new Location(new Namespace("s23684"), "John");
        Person person = new Person("John", "Smith", 20);

        StoreValue sv = new StoreValue.Builder(person).withLocation(location).build();
        StoreValue.Response svResponse = client.execute(sv);
        System.out.println("Insert response: " + svResponse);
        System.out.println("Inserted: " + person);

        FetchValue fv = new FetchValue.Builder(location).build();
        FetchValue.Response response = client.execute(fv);
        System.out.println("Get response: " + response);

        Person john = response.getValue(Person.class);
        System.out.println("Reading: " + john);

        UpdateValue svUpdated = new UpdateValue.Builder(location)
                .withFetchOption(FetchValue.Option.DELETED_VCLOCK, true)
                .withUpdate(new UpdateAge(30))
                .build();
        UpdateValue.Response svResponseUpdated = client.execute(svUpdated);
        System.out.println("Update response: " + svResponseUpdated);

        FetchValue fvUpdated = new FetchValue.Builder(location).build();
        FetchValue.Response responseUpdated = client.execute(fv);
        System.out.println("Get response: " + responseUpdated);

        Person johnUpdated = responseUpdated.getValue(Person.class);
        System.out.println("Reading: " + johnUpdated);

        DeleteValue dv = new DeleteValue.Builder(location).build();
        client.execute(dv);

        FetchValue.Response responseDeleted = client.execute(fv);
        System.out.println("Delete response: " + responseDeleted);

        client.shutdown();
    }

}
