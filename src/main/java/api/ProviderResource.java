package api;

import api.exceptions.AlreadyExistProviderFieldException;
import api.exceptions.MalformedHeaderException;
import controllers.ProviderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wrappers.ProviderWrapper;
import wrappers.ProvidersWrapper;

@RestController
@RequestMapping(Uris.VERSION)
public class ProviderResource {

    private ProviderController providerController;

    @Autowired
    public void setProviderController(ProviderController providerController) {
        this.providerController = providerController;
    }

    @RequestMapping(value = Uris.PROVIDERS, method = RequestMethod.POST)
    public void providerRegistration(@RequestBody ProviderWrapper providerWrapper)
            throws MalformedHeaderException, AlreadyExistProviderFieldException {
        validateFields(providerWrapper);
        if (!this.providerController.registration(providerWrapper)) {
            throw new AlreadyExistProviderFieldException();
        }
    }

    @RequestMapping(value = Uris.PROVIDERS, method = RequestMethod.GET)
    public ProvidersWrapper getAll() throws Exception {
        return providerController.getAll();
    }

    @RequestMapping(value = Uris.PROVIDERS, method = RequestMethod.PUT)
    public ProviderWrapper providerUpdate(@RequestBody ProviderWrapper providerWrapper) throws Exception {
        ProviderWrapper wrapper = providerController.editProvider(providerWrapper);
        return wrapper;
    }

    @RequestMapping(value = Uris.PROVIDERS, method = RequestMethod.DELETE)
    public void providerDelete(String id) throws Exception {
        providerController.delete(id);
    }

    private void validateFields(ProviderWrapper providerWrapper) throws MalformedHeaderException {
        if (providerWrapper.getCompany() == null || providerWrapper.getMobile() == 0L) {
            throw new MalformedHeaderException();
        }
    }
}
