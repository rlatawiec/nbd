import com.basho.riak.client.api.commands.kv.UpdateValue;

public class UpdateAge extends UpdateValue.Update<Person> {

    private Integer newAge;

    public UpdateAge(Integer newAge) {
        this.newAge = newAge;
    }

    @Override
    public Person apply(Person person) {
        person.setAge(newAge);
        return person;
    }
}
