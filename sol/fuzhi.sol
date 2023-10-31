// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;
contract fuzhiTest{
    uint public  id;
    string public name;
    uint public  constant age = 50;

    function setzhi(uint _id,string memory _inp) public {
        id=_id;
        name=_inp;
    }
    function getzi()public {        
        setzhi({_inp:unicode"杨金龙",_id:1});
       
    }
    function kk () public view  returns(uint){
        return age+11;
    }
    constructor(){
        
    }
}

contract funadaf{
    address public mad;
    uint public age;
    constructor (){
        mad=msg.sender;
    }

    modifier Only(){
        require(msg.sender==mad);
        _;
    }
    function setAge(uint _age) public Only{
        age=_age;
    }

}