package in.ga.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/currency")
public class CurrencyConverterService {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD_TO_INR", 83.0);
        exchangeRates.put("EUR_TO_INR", 90.0);
    }

    @GET
    @Path("/convert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertCurrency(@QueryParam("from") String from,
            @QueryParam("to") String to,
            @QueryParam("amount") double amount) {
        String key = from.toUpperCase() + "_TO_" + to.toUpperCase();
        if (!exchangeRates.containsKey(key)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Exchange rate for " + key + " not available.")
                    .build();
        }
        double rate = exchangeRates.get(key);
        double convertedAmount = amount * rate;
        Map<String, Object> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);
        response.put("amount", amount);
        response.put("convertedAmount", convertedAmount);
        return Response.ok(response).build();
    }
}