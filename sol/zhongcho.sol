// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract zhongcoTest{
    struct fand{
        address adds;
        uint memary;
    }
    struct netfand{
        address netaddress;
        uint gotaol;
        uint account;
        uint fandid;
        bool istrue;
        mapping (uint=>fand) map;
    }
    uint netid;
    mapping (uint=>netfand)public netmap;

    function creanet(uint _gotal)public {        
        netid++;
        netfand storage n = netmap[netid];
        n.netaddress= msg.sender;
        n.gotaol=_gotal;
        n.fandid=0;
        n.account=0;
    }

    function setnet(uint _netid)public  payable {
        // payable(address(this)).transfer(msg.value);
        //下方的是想这个合约转账当后面捐款额达到数值后就从合约中转给受益人，下面的公式可以不写默认可以转账但需要加payable修饰
        netfand storage n = netmap[_netid];
        n.account+=msg.value;
        n.fandid++;
        n.map[n.fandid]=fand(msg.sender,msg.value);
    }
    function isgo(uint _netid)public {
        netfand storage n = netmap[_netid];
        
        if(n.gotaol<=n.account){
            payable(n.netaddress).transfer(n.account);
            n.istrue=true;
        }
    }
}