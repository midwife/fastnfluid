package controllers;

import play.api.mvc.Controller;
import play.libs.F;
import play.mvc.Result;
import play.mvc.Security;

import java.util.LinkedList;

import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 01/01/2016.
 */
@Security.Authenticated(Secured.class)
public class LiveFeedController {
  private int count=0;
  private LinkedList<String> message= new LinkedList<>();

  public Result getLivefeedWithWildCard(String wildcard) {
    int dummyInt = (int)(Math.random()*10);
    this.message.add("#Mission"+dummyInt+" : test live feed<br />\n");
    this.count++;
    String tempMessage= "";
    for (int i=0; i< this.message.size(); i++) {
      tempMessage+= this.message.get(i);
    }
    return ok(tempMessage);
  }
  public Result getLivefeed() {
    return getLivefeedWithWildCard("");
  }
}
