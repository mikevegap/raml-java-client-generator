
package x-www-form-urlencoded.resource.sendFormData;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import x-www-form-urlencoded.exceptions.TestsendformdataException;
import x-www-form-urlencoded.resource.sendFormData.model.SendFormDataPOSTBody;

public class SendFormData {

    private String _baseUrl;
    private Client client;

    public SendFormData(String baseUrl, Client client) {
        _baseUrl = (baseUrl +"/sendFormData");
        this.client = client;
    }

    protected Client getClient() {
        return this.client;
    }

    private String getBaseUri() {
        return _baseUrl;
    }

    public void post(SendFormDataPOSTBody body) {
        WebTarget target = this.client.target(getBaseUri());
        final javax.ws.rs.client.Invocation.Builder invocationBuilder = target.request(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE);
        MultivaluedMap multiValuedMap = new MultivaluedHashMap();
        if (body.getParam1()!= null) {
            multiValuedMap.add("param1", body.getParam1().toString());
        }
        if (body.getParam2()!= null) {
            multiValuedMap.add("param2", body.getParam2().toString());
        }
        Response response = invocationBuilder.post(Entity.entity(multiValuedMap, javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        if (response.getStatusInfo().getFamily()!= Family.SUCCESSFUL) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new TestsendformdataException(statusInfo.getStatusCode(), statusInfo.getReasonPhrase());
        }
    }

}
