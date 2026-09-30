class NameTag {

```
private final String firstName;
private final String lastName;

// Constructor
NameTag(String fullName) {

    String[] parts = fullName.split(" ");

    firstName = parts[0];
    lastName = parts[1];
}

// Return nickname
String getNickname() {

    return firstName + " " + lastName.charAt(0) + ".";
}
```

}

public class Main {
public static void main(String[] args) {

```
    NameTag tag = new NameTag("Maria Gomez");

    System.out.println("Nickname: " + tag.getNickname());
}
```

}

