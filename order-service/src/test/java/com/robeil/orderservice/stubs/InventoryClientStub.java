package com.robeil.orderservice.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class InventoryClientStub {

    public static void stubInventory(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/api/inventories?skuCode=" + skuCode +"&quantity="+quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type","application/json")
                        .withBody("true")
                )
        );
    }
}
