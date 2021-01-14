/product

    GET /getproduct/{productId}
        http://localhost:8080/product/getproduct/"id"

        returns product
            {
                "category": "das",
                "stock": 24,
                "attribute": [
                    {
                        "attributeKey": "asdas",
                        "getAttributeValue": "sfece"
                    },
                    {
                        "attributeKey": "vezsa",
                        "getAttributeValue": "ienvr"
                    }
                ],
                "images": [
                    "asdasdasdasd",
                    "asdasd"
                ],
                "productId": "60000dccfd0c4858105824d6"
            }

    GET /getallproducts/
        http://localhost:8080/product/getallproducts

        returns List<Product>
            [
                {
                    "category": "das",
                    "stock": 24,
                    "attribute": [
                        {
                            "attributeKey": "asdas",
                            "getAttributeValue": "sfece"
                        },
                        {
                            "attributeKey": "vezsa",
                            "getAttributeValue": "ienvr"
                        }
                    ],
                    "images": null,
                    "productId": "600007bd395fe70496abb42d"
                },
                {
                    "category": "das",
                    "stock": 24,
                    "attribute": [
                        {
                            "attributeKey": "asdas",
                            "getAttributeValue": "sfece"
                        },
                        {
                            "attributeKey": "vezsa",
                            "getAttributeValue": "ienvr"
                        }
                    ],
                    "images": [
                        "asdasdasdasd",
                        "asdasd"
                    ],
                    "productId": "60000dccfd0c4858105824d6"
                }
            ]

    POST /addproduct
        http://localhost:8080/product/addproduct
            {
             "category":"das",
             "stock":24,
             "attribute":[
                 {
                     "attributeKey": "asdas",
                     "getAttributeValue": "sfece"
                 },
                 {
                     "attributeKey": "vezsa",
                     "getAttributeValue": "ienvr"
                 }
             ],
             "images": [
                 "asdasdasdasd",
                 "asdasd"

             ]
            }
        returns added product
            {
                "category": "das",
                "stock": 24,
                "attribute": [
                    {
                        "attributeKey": "asdas",
                        "getAttributeValue": "sfece"
                    },
                    {
                        "attributeKey": "vezsa",
                        "getAttributeValue": "ienvr"
                    }
                ],
                "images": [
                    "asdasdasdasd",
                    "asdasd"
                ],
                "productId": "60000ec0fd0c4858105824d7"
            }

    GET /getStock/{productId}
        http://localhost:8080/product/getStock/"id"

        returns int(Stock)
