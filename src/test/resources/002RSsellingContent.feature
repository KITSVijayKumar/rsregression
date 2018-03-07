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
    And the user updates Selling Content Attributes 'BulletPointsXX:' 'Copy:' 'Descriptions:' 'Functional:' 'ShippingMethod:' 'USPs:'
      | BulletPointsXX                                   | Copy                                                   | Descriptions                                                   | Functional                                     | ShippingMethod | USPs                                                                        |
      | v2 Scotland landscapes Test 05 Wed 22nd Feb 2018 | Hired to write Test - BodyCopy - Wed 14th Feb 2018     | We bring good things to life -MedDesc -Test -Wed 14th Feb 2018 | TEST_ContGrp_HelpandAdvice_Wed 14th Feb 2018   | SHPM_1040219   | Consumer to be interested in TEST - UniqueSellingPoint 01 Wed 14th Feb 2018 |
      | v2 Scotland landscapes Test 06 Wed 22nd Feb 2018 | Opco Selling Copy Test - Wed 14th Feb 2018             | Visit the GLOSSARY -ShtDesc -Test -Wed 14th Feb 2018           | TEST_ContGrp_ProductFeatures_Wed 14th Feb 2018 | SHPM_1363191   | Consumer to be interested in TEST - UniqueSellingPoint 02 Wed 14th Feb 2018 |
      | v2 Scotland landscapes Test 07 Wed 22nd Feb 2018 | OverRide BodyCopy Test - Wed 14th Feb 2018             |                                                                | VJ_Version1_Wed 14th Feb 2018                  |                | Consumer to be interested in TEST - UniqueSellingPoint 03 Wed 14th Feb 2018 |
      | v2 Scotland landscapes Test 08 Wed 22nd Feb 2018 | A Press Release Test - SellingCopy - Wed 14th Feb 2018 |                                                                | LTP                                            |                | Consumer to be interested in TEST - UniqueSellingPoint 04 Wed 14th Feb 2018 |
      | v2 Scotland landscapes Test 09 Wed 22nd Feb 2018 |                                                        |                                                                |                                      100010001 |                | Consumer to be interested in TEST - UniqueSellingPoint 05 Wed 14th Feb 2018 |
      | v2 Scotland landscapes Test 10 Wed 22nd Feb 2018 |                                                        |                                                                |                                                |                | Consumer to be interested in TEST - UniqueSellingPoint 06 Wed 14th Feb 2018 |
      |                                                  |                                                        |                                                                |                                                |                | Consumer to be interested in TEST - UniqueSellingPoint 07 Wed 14th Feb 2018 |
      |                                                  |                                                        |                                                                |                                                |                | Consumer to be interested in TEST - UniqueSellingPoint 08 Wed 14th Feb 2018 |
      |                                                  |                                                        |                                                                |                                                |                | Consumer to be interested in TEST - UniqueSellingPoint 09 Wed 14th Feb 2018 |
      |                                                  |                                                        |                                                                |                                                |                | Consumer to be interested in TEST - UniqueSellingPoint 10 Wed 14th Feb 2018 |
    And checks the workflow action and product ean is Promoted
    Then the user quits browser windows

    Examples: 
      | EAN           |
      #| 5036211049052 |
      #| 5036211049069 |
      #| 5036211049076 |
      #| 5036211049083 |
      #| 5036211049250 |
      #| 5036211049267 |
      #| 5036211049274 |
      #| 5036211049281 |
      #||
      #| 5397007065688 |
      #| 5397007065695 |
      #||
      #| 5397007062984 |
      #| 5397007063004 |
      #||
      #| 5397007063028 |
      #| 5397007063042 |
      #||
      | 5010212479568 |

  #| 5397007065220 |
  #| 5397007065244 |
  #| 5397007065183 |
  #| 5397007065206 |
  #| 5397007065992 |
  #| 5397007065923 |
  #| 5397007066005 |
  #| 5397007065916 |
  #| 5060178977097 |
  #| 5036211048741 |
  #| 5010212555231 |
  #| 5010212555255 |
  #| 5010212555279 |
  #| 5010212555170 |
  #| 5010212555217 |
  @SellingContentPush @SellingContentExport
  Scenario: Export the SellingContent Profile
    When the user exports the SellingContent Profile
      | ProfileSearch                               |
      #| JG TEMP Selling Content                     |
      | Selling Content - STEPERSAND BandQ Outbound |
    #Then the user quits browser windows
