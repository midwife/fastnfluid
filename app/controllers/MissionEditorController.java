package controllers;

import play.mvc.*;
import views.html.mission_editor;

/**
 * Created by midwife123 on 26/01/2016.
 */

@Security.Authenticated(Secured.class)
public class MissionEditorController extends Controller {
    public Result editor () {
        return ok(mission_editor.render());
    }

    public Result getFile() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        /*Http.MultipartFormData.FilePart fileData = body.getFiles().get(0);

        if (fileData != null) {
            String fileName = fileData.getFilename();
            String contentType = fileData.getContentType();
            java.io.File file = fileData.getFile();

            boolean isRenamed = file.renameTo( new java.io.File("public/upload",fileName));

            return ok(isRenamed+"? File "+file.toString()+" CT / "+contentType+" -> uploaded");
        } else {
            flash("error","missing file");
            return badRequest();
        }*/

        return ok("TODO");
    }
}
