// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract demo1{
    uint private a1=111;
    uint public  b1=212;
    function demotext1()public pure  returns (string memory){
        return unicode"杨金龙1";
    }
    function demotext12()internal view  returns (string memory){
        return unicode"demo12";
    }
}

contract demo2 is demo1{
    uint private a2=111;
    uint public  b2=212;
    function demotext2()public pure returns (string memory){
        return unicode"demo2";
    }
    function demotext22()private  pure returns (string memory){
        return unicode"test22";
    }
    function demotext23()external pure returns (string memory){
        return unicode"nadd22";
    }
}

contract demo3 is demo2{
    function getdemo() public view  returns(string memory){
        return demotext12();
    }

    //is是用于继承使用的关键字
    //public，private，external，internal共有这四个权限修饰符
    //public公开的  private私人的  external在继承中需要使用this.函数名或者父合约名(this).函数名并且修饰过的函数在此合约内部不能调用此函数，但可以在外部调用和继承的子合约中调用
    //pure和view都是用于不修改任何资金的
    //internal 是不公开的但是可以在调用中去使用到可以在内部和调用和继承的子合于中调用但不显示
}

