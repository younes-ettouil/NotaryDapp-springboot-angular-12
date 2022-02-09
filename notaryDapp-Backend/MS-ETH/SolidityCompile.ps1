Remove-Item ./src/main/resources/SmartContracts/build/*.* -Force

solcjs ./src/main/resources/SmartContracts/Property.sol --bin --abi --optimize -o ./src/main/resources/SmartContracts/build/
Write-Host "The smart contract was compiled successfully"

Rename-Item ./src/main/resources/SmartContracts/build/src_main_resources_SmartContracts_Property_sol_PropertyContract.bin PropertyContract.bin
Rename-Item ./src/main/resources/SmartContracts/build/src_main_resources_SmartContracts_Property_sol_PropertyContract.abi PropertyContract.abi

web3j generate solidity -b ./src/main/resources/SmartContracts/build/PropertyContract.bin -a ./src/main/resources/SmartContracts/build/PropertyContract.abi -o ./src/main/java -p me.abdellm.notarydappsmartcontract.contratcs
Write-Host "Java code was generated successfully"