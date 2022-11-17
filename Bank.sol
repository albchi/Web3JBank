pragma solidity >0.7.0;

contract Bank { 

   uint256 balance;

   string public name;

   // constructor() public {
   constructor() {
      name = "Madoff";
   }
   function init(uint256 i) public {
      balance = i;
   }
   function checkbalance() public view returns(uint256) {
      return balance;
   }
   function getname() public view returns(string memory) {
      return name;
   }
} // contract
