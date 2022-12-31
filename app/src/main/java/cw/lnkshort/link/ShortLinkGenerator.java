package cw.lnkshort.link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortLinkGenerator {
  public String generate(){
    List<Character> characters = new ArrayList<>();
    for(char c = 'a'; c <= 'z'; c++){
      characters.add(c);
    }
    for(char c = 'A'; c <= 'Z'; c++){
      characters.add(c);
    }
    for(char c = '0'; c <= '9'; c++){
      characters.add(c);
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      Collections.shuffle(characters);
      stringBuilder.append(characters.get(0));
    }
    return stringBuilder.toString();
  }
}
