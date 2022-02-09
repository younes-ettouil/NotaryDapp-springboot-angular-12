// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

contract PropertyContract {
    mapping(string => Property) public properties;
    uint public propertiesLength = 0 ;

    struct Property {
        string conservationNumber;
        string idPurchaseContract;
        uint price;
        address[] owners;
    }

    function createProperty(string memory _conservationNumber, string memory _idPurchaseContract, uint _price, address[] memory _owners) public {
        // Check if inputs are valid
        require(bytes(_conservationNumber).length > 0);
        require(bytes(_idPurchaseContract).length > 0);
        require(_price > 0);
        for (uint i = 0; i <_owners.length; i++)
            require(_owners[i] != address(0));

        // Create new property
        properties[_conservationNumber] = Property(_conservationNumber, _idPurchaseContract, _price, _owners);

        // Increment properties counts
        propertiesLength++;
    }

    function getOwners(string memory _conservationNumber)public view returns(address[] memory){
        return properties[_conservationNumber].owners;
    }
}