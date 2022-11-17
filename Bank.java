package com.vmbc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@SuppressWarnings("rawtypes")
public class Bank extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506040518060400160405280600681526020017f4d61646f666600000000000000000000000000000000000000000000000000008152506001908161005591906102ab565b5061037d565b600081519050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806100dc57607f821691505b6020821081036100ef576100ee610095565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b6000600883026101577fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8261011a565b610161868361011a565b95508019841693508086168417925050509392505050565b6000819050919050565b6000819050919050565b60006101a86101a361019e84610179565b610183565b610179565b9050919050565b6000819050919050565b6101c28361018d565b6101d66101ce826101af565b848454610127565b825550505050565b600090565b6101eb6101de565b6101f68184846101b9565b505050565b5b8181101561021a5761020f6000826101e3565b6001810190506101fc565b5050565b601f82111561025f57610230816100f5565b6102398461010a565b81016020851015610248578190505b61025c6102548561010a565b8301826101fb565b50505b505050565b600082821c905092915050565b600061028260001984600802610264565b1980831691505092915050565b600061029b8383610271565b9150826002028217905092915050565b6102b48261005b565b67ffffffffffffffff8111156102cd576102cc610066565b5b6102d782546100c4565b6102e282828561021e565b600060209050601f8311600181146103155760008415610303578287015190505b61030d858261028f565b865550610375565b601f198416610323866100f5565b60005b8281101561034b57848901518255600182019150602085019450602081019050610326565b868310156103685784890151610364601f891682610271565b8355505b6001600288020188555050505b505050505050565b6103d48061038c6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806306fdde0314610051578063b7b0422d1461006f578063c6ea59b91461008b578063eaa9600b146100a9575b600080fd5b6100596100c7565b604051610066919061028a565b60405180910390f35b610089600480360381019061008491906102e7565b610155565b005b61009361015f565b6040516100a0919061028a565b60405180910390f35b6100b16101f1565b6040516100be9190610323565b60405180910390f35b600180546100d49061036d565b80601f01602080910402602001604051908101604052809291908181526020018280546101009061036d565b801561014d5780601f106101225761010080835404028352916020019161014d565b820191906000526020600020905b81548152906001019060200180831161013057829003601f168201915b505050505081565b8060008190555050565b60606001805461016e9061036d565b80601f016020809104026020016040519081016040528092919081815260200182805461019a9061036d565b80156101e75780601f106101bc576101008083540402835291602001916101e7565b820191906000526020600020905b8154815290600101906020018083116101ca57829003601f168201915b5050505050905090565b60008054905090565b600081519050919050565b600082825260208201905092915050565b60005b83811015610234578082015181840152602081019050610219565b60008484015250505050565b6000601f19601f8301169050919050565b600061025c826101fa565b6102668185610205565b9350610276818560208601610216565b61027f81610240565b840191505092915050565b600060208201905081810360008301526102a48184610251565b905092915050565b600080fd5b6000819050919050565b6102c4816102b1565b81146102cf57600080fd5b50565b6000813590506102e1816102bb565b92915050565b6000602082840312156102fd576102fc6102ac565b5b600061030b848285016102d2565b91505092915050565b61031d816102b1565b82525050565b60006020820190506103386000830184610314565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061038557607f821691505b6020821081036103985761039761033e565b5b5091905056fea26469706673582212206755dbe1962258c7ad5ed550f26d0c7faf8d732d76f30c1bf5d853cc200ab8bd64736f6c63430008110033";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_INIT = "init";

    public static final String FUNC_CHECKBALANCE = "checkbalance";

    public static final String FUNC_GETNAME = "getname";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Bank(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bank(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bank(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bank(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }
    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> init(BigInteger i) {
        final Function function = new Function(
                FUNC_INIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> checkbalance() {
        final Function function = new Function(FUNC_CHECKBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getname() {
        final Function function = new Function(FUNC_GETNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Bank load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bank(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bank(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bank load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bank(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bank(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bank> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bank.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Bank> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bank.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bank> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bank.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bank> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bank.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
