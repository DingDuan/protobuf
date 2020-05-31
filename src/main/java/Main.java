import com.google.protobuf.InvalidProtocolBufferException;
import proto.com.example.tutorial.AddressBookProtos;

public class Main {

    public static void main(String[] args){
        //序列化
        //AddressBookProtos是生成类的名字，即proto文件中的java_outer_classname
        //Person是里面某个序列的名字，即proto文件中的message Person
        AddressBookProtos.Person.Builder builder = AddressBookProtos.Person.newBuilder();
        builder.setName("duanding");
        builder.setId(1);

        //Person
        AddressBookProtos.Person info = builder.build();

        byte[] result = info.toByteArray();

        //反序列化
        try{
            AddressBookProtos.Person person = AddressBookProtos.Person.parseFrom(result);
            System.out.println(person);
        }catch (InvalidProtocolBufferException e){
            e.printStackTrace();
        }
    }
}
