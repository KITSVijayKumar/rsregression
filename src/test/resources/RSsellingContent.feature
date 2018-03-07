Feature: Push the Sellable Content Key attributes for a given Product Ean in Stepersand container

  Background: Verify User is logged in
    Given the user is able to login and navigate to stepersand container
      | username | password |
      | XXXXXXXX | XXXXXXXX |

  @SellingContentPush @updateAttributeValues
  Scenario Outline: Verify the SellingContent data is updated and approved for the corresponding key attribute fields.
    When the user search a product "<EAN>" using the search criteria
    Then the user should be able to see the product "<EAN>" is available
    When the user selects the required product ean
    Then the user will navigate to Attribute page in a new tab
    And the user updates 'Copy:'
      | Copy                                                   |
      | Hired to write Test - BodyCopy - Tue 06th Mar 2018     |
      | Opco Selling Copy Test - Tue 06th Mar 2018             |
      | OverRide BodyCopy Test - Tue 06th Mar 2018             |
      | A Press Release Test - SellingCopy - Tue 06th Mar 2018 |
    And the user updates Selling Content Attributes 'BulletPointsXX:'
      | BulletPointsXX                                   |
      | v2 Scotland landscapes Test 05 Tue 06th Mar 2018 |
      | v2 Scotland landscapes Test 06 Tue 06th Mar 2018 |
      | v2 Scotland landscapes Test 07 Tue 06th Mar 2018 |
      | v2 Scotland landscapes Test 08 Tue 06th Mar 2018 |
      | v2 Scotland landscapes Test 09 Tue 06th Mar 2018 |
      | v2 Scotland landscapes Test 10 Tue 06th Mar 2018 |
    And the user updates 'Descriptions:'
      | Descriptions                                |
      | We bring good things to life - MedDesc-Test |
      | Visit the GLOSSARY - ShtDesc - Test         |
    And the user updates 'Functional:'
      | Functional                   |
      | TEST_ContGrp_HelpandAdvice   |
      | TEST_ContGrp_ProductFeatures |
      | VJ_Version1_                 |
      | LTP                          |
      |                    100010001 |
    And the user updates 'ShippingMethod:'
      | ShippingMethod |
      | SHPM_1040219   |
      | SHPM_1363191   |
    #|for otherShipping Select All|
    And the user updates 'TechSpecs:'
      | TechSpecs                                     |
      | TechnicalSpecifications in TEST - TechSpec 20 |
      | TechnicalSpecifications in TEST - TechSpec 21 |
    And the user updates 'USPs:'
      | USPs                                                                          |
      | Consumer to be interested in TEST - UniqueSellingPoint 01 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 02 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 03 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 04 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 05 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 06 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 07 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 08 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 09 - Tue 06th Mar 2018 |
      | Consumer to be interested in TEST - UniqueSellingPoint 10 - Tue 06th Mar 2018 |
    And checks the workflow action and product ean is Promoted
    Then the user quits browser windows

    Examples: 
      | EAN           |
      | 5036211048741 |
      | 5010212555231 |

  #| 5010212555255 |
  #| 5010212555279 |
  #|5010212555170|
  #|5010212555217|
  @SellingContentPush @SellingContentExport
  Scenario: Export the SellingContent Profile
    When the user exports the SellingContent Profile
      | ProfileSearch                               |
      | Selling Content - STEPERSAND BandQ Outbound |
      #| JG TEMP Selling Content |
    #Then the user quits browser windows
