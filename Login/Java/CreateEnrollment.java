import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.FileInputStream;

public class CreateEnrollment 
{
    public static void main(String[] args) 
    {
        HttpClient httpclient = HttpClients.createDefault();

        String verificationProfileId = "set-verification-profile-id-user";

        try
        {
            URIBuilder builder = new URIBuilder(
				"https://westus.api.cognitive.microsoft.com/spid/v1.0/verificationProfiles/"
					+ verificationProfileId + "/enroll");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "multipart/form-data");
            request.setHeader("Ocp-Apim-Subscription-Key", "set-key");

			request.setEntity(new InputStreamEntity(new FileInputStream("set-audio-wav")));

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
