package egovframework.pf.member.utill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import egovframework.pf.member.sevice.MemberCodeService;
import egovframework.pf.member.sevice.MemberService;

import java.util.HashMap;
import java.util.Map;

@Component
public class IpAddressUtill {
    private static final Log LOGGER = LogFactory.getLog(IpAddressUtill.class);

    private static MemberService memberservice;

    @Autowired
    public void setCodeService(MemberService memberservice) {
        IpAddressUtill.memberservice = memberservice;
    }

    public static String getIpAddress()throws Exception{
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("MSG_ID", "mailip");
        param.put("LANG", "kr");
        Map<String, Object> ip = memberservice.getMailCode(param);

        return ip.get("MSG_ID").toString();
    }
}
