package com.notaryDapp.eth.contratcs;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class PropertyContract extends Contract {
    public static final String BINARY = "6080604052600060015534801561001557600080fd5b50610852806100256000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806340e4a05e146100515780636057d21b1461006d5780639be8f2a61461008d578063dad12228146100af575b600080fd5b61005a60015481565b6040519081526020015b60405180910390f35b61008061007b36600461055c565b6100c4565b6040516100649190610599565b6100a061009b36600461055c565b610141565b60405161006493929190610642565b6100c26100bd366004610678565b61027e565b005b60606000826040516100d69190610786565b908152604080519182900360209081018320600301805480830285018301909352828452919083018282801561013557602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610117575b50505050509050919050565b8051602081830181018051600082529282019190930120915280548190610167906107a2565b80601f0160208091040260200160405190810160405280929190818152602001828054610193906107a2565b80156101e05780601f106101b5576101008083540402835291602001916101e0565b820191906000526020600020905b8154815290600101906020018083116101c357829003601f168201915b5050505050908060010180546101f5906107a2565b80601f0160208091040260200160405190810160405280929190818152602001828054610221906107a2565b801561026e5780601f106102435761010080835404028352916020019161026e565b820191906000526020600020905b81548152906001019060200180831161025157829003601f168201915b5050505050908060020154905083565b600084511161028c57600080fd5b600083511161029a57600080fd5b600082116102a757600080fd5b60005b81518110156102fe5760006001600160a01b03168282815181106102d0576102d06107dd565b60200260200101516001600160a01b031614156102ec57600080fd5b806102f6816107f3565b9150506102aa565b506040518060800160405280858152602001848152602001838152602001828152506000856040516103309190610786565b9081526020016040518091039020600082015181600001908051906020019061035a9291906103b7565b50602082810151805161037392600185019201906103b7565b50604082015160028201556060820151805161039991600384019160209091019061043b565b505060018054915060006103ac836107f3565b919050555050505050565b8280546103c3906107a2565b90600052602060002090601f0160209004810192826103e5576000855561042b565b82601f106103fe57805160ff191683800117855561042b565b8280016001018555821561042b579182015b8281111561042b578251825591602001919060010190610410565b50610437929150610490565b5090565b82805482825590600052602060002090810192821561042b579160200282015b8281111561042b57825182546001600160a01b0319166001600160a01b0390911617825560209092019160019091019061045b565b5b808211156104375760008155600101610491565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff811182821017156104e4576104e46104a5565b604052919050565b600082601f8301126104fd57600080fd5b813567ffffffffffffffff811115610517576105176104a5565b61052a601f8201601f19166020016104bb565b81815284602083860101111561053f57600080fd5b816020850160208301376000918101602001919091529392505050565b60006020828403121561056e57600080fd5b813567ffffffffffffffff81111561058557600080fd5b610591848285016104ec565b949350505050565b6020808252825182820181905260009190848201906040850190845b818110156105da5783516001600160a01b0316835292840192918401916001016105b5565b50909695505050505050565b60005b838110156106015781810151838201526020016105e9565b83811115610610576000848401525b50505050565b6000815180845261062e8160208601602086016105e6565b601f01601f19169290920160200192915050565b6060815260006106556060830186610616565b82810360208401526106678186610616565b915050826040830152949350505050565b6000806000806080858703121561068e57600080fd5b843567ffffffffffffffff808211156106a657600080fd5b6106b2888389016104ec565b95506020915081870135818111156106c957600080fd5b6106d589828a016104ec565b955050604087013593506060870135818111156106f157600080fd5b8701601f8101891361070257600080fd5b803582811115610714576107146104a5565b8060051b92506107258484016104bb565b818152928201840192848101908b85111561073f57600080fd5b928501925b8484101561077657833592506001600160a01b03831683146107665760008081fd5b8282529285019290850190610744565b989b979a50959850505050505050565b600082516107988184602087016105e6565b9190910192915050565b600181811c908216806107b657607f821691505b602082108114156107d757634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603260045260246000fd5b600060001982141561081557634e487b7160e01b600052601160045260246000fd5b506001019056fea2646970667358221220a3f1d268601955664270e3e23d39d46310770dd0cb533a10829ca35fd57e4cb764736f6c634300080a0033";

    public static final String FUNC_CREATEPROPERTY = "createProperty";

    public static final String FUNC_GETOWNERS = "getOwners";

    public static final String FUNC_PROPERTIES = "properties";

    public static final String FUNC_PROPERTIESLENGTH = "propertiesLength";

    @Deprecated
    protected PropertyContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PropertyContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PropertyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PropertyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> createProperty(String _conservationNumber, String _idPurchaseContract, BigInteger _price, List<String> _owners) {
        final Function function = new Function(
                FUNC_CREATEPROPERTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_conservationNumber), 
                new org.web3j.abi.datatypes.Utf8String(_idPurchaseContract), 
                new org.web3j.abi.datatypes.generated.Uint256(_price), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_owners, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getOwners(String _conservationNumber) {
        final Function function = new Function(FUNC_GETOWNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_conservationNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<String, String, BigInteger>> properties(String param0) {
        final Function function = new Function(FUNC_PROPERTIES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, BigInteger>>(function,
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> propertiesLength() {
        final Function function = new Function(FUNC_PROPERTIESLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static PropertyContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PropertyContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PropertyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PropertyContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PropertyContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PropertyContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PropertyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PropertyContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PropertyContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PropertyContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PropertyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PropertyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PropertyContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PropertyContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PropertyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PropertyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
