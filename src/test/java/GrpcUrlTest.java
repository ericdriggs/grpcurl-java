import com.github.fullstorydev.grpcurl.Grpcurl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GrpcUrlTest {

    @Test
    void grpcUrlTest() {
        List<String> params = Arrays.asList(
                "-d",
                "'{\"configName\": \"assertion\", \"dimensionQueries\":[{\"key\":\"countryOrRegion\", \"sVal\":\"BR\"}]}'",
                "--insecure",
                "config-service-qa.us-east-1.dpegrid.net:443",
                "ConfigServer.ConfigServer/GetConfig");
        Grpcurl.main(params.toArray(new String[0]));
    }
}
