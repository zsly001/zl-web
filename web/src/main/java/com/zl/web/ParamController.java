package com.zl.web;

import com.zl.domain.po.adm.Role;
import com.zl.dto.UserDTO;
import com.zl.dto.UserRequest;
import com.zl.vo.ApiResponse;
import com.zl.vo.ServletInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/p")
public class ParamController {

    private static final Logger log = LoggerFactory.getLogger(ParamController.class);

    private static final Logger wk = LoggerFactory.getLogger("wk");

    private Random random = new Random();

    @GetMapping("/sp")
    public ApiResponse<ServletInfoVO> getServletParam(HttpServletRequest request,
                                               HttpServletResponse response,
                                               HttpSession session,
                                               @RequestParam(value = "id",required = false) Long id){
        System.out.println("servlet param ...");
        request.setAttribute("r","abc");
        session.setAttribute("p","abc");
        ServletInfoVO vo = new ServletInfoVO();
        vo.setRequest(request.toString());
        vo.setSession(session.toString());
        return ApiResponse.ok(vo);
    }

    @GetMapping("/sc")
    public ApiResponse<ServletInfoVO> scope(HttpServletRequest request,HttpSession session){
        System.out.println("scope");
        int scount = 0;
        int rcount = 0;
        ServletInfoVO vo = new ServletInfoVO();
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            vo.addSesAttr(name,session.getAttribute(name).toString());
            scount++;
        }
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            vo.addReqAttr(name,request.getAttribute(name).toString());
            rcount++;
        }
        vo.setRequestAttrCount(rcount);
        vo.setSessionAttrCount(scount);
        vo.setRequest(request.toString());
        vo.setSession(session.toString());
        log.info("servlet info is {}",vo);
        return ApiResponse.ok(vo);
    }

    @GetMapping("/get")
    public ApiResponse<String> getParam(HttpServletRequest request,
                                        @RequestParam("name") String name,
                                        @RequestParam("price")BigDecimal price){

        StringBuilder sb = new StringBuilder("param is ");
        String reqName = (String)request.getAttribute("name");
        BigDecimal reqPrice = (BigDecimal)request.getAttribute("price");
        String reqParaName = request.getParameter("name");
        String reqParaPrice = request.getParameter("price");
        sb.append("reqName=").append(reqName).append(";")
                .append("reqPrice=").append(reqPrice).append(";");
        sb.append("reqParaName=").append(reqParaName).append(";")
                .append("reqParaPrice=").append(reqParaPrice).append(";");
        sb.append("name=").append(name).append(";")
                .append("price=").append(price);
        log.info("get param is {}",sb);
        wk.info("{}",sb);
        return ApiResponse.ok(sb.toString());

    }

    @GetMapping("/getobj")
    public ApiResponse<UserDTO> getParamObject(@RequestParam("user") UserDTO userDTO){
        log.debug("get obj userdto is {}",userDTO);
        return ApiResponse.ok(userDTO);

    }

    @GetMapping("/list")
    public ApiResponse<List<Role>> getRolues(@RequestParam("type") List<Integer> types){
        System.out.println("types is "+types);
        List<Role> roles = new ArrayList<>();
        for(int i=0;i<10;i++){
            Role role = new Role();
            role.setRid(i);
            role.setName("n"+random.nextInt(100));
            role.setStatus(random.nextInt(2));
            roles.add(role);
        }
        return ApiResponse.ok(roles);
    }

    @GetMapping("/line")
    public ApiResponse<String> line(@RequestParam("label_name") String name){
        log.warn("line is {}",name);
        return ApiResponse.ok(name);
    }

    @GetMapping("/path/{id}")
    public ApiResponse<String> path(@PathVariable("id") Integer id){
        log.trace("path is {}",id);
        return ApiResponse.ok(id+"");
    }

    @PostMapping("/u")
    public ApiResponse<UserRequest> user(@RequestBody UserRequest user){
        return ApiResponse.ok(user);
    }

    @GetMapping("/gu/{name}/{age}/{email}")
    public ApiResponse<UserRequest> guser(UserRequest user){
        return ApiResponse.ok(user);
    }

    @GetMapping("/gu")
    public ApiResponse<UserRequest> guserobj(UserRequest user){
        log.debug("get obj UserRequest is {}",user);
        return ApiResponse.ok(user);
    }

    @GetMapping("/ck")
    public ApiResponse<String> ck(@CookieValue("JSESSIONID") String jsid){
        log.error("cookie is {}",jsid);
        return ApiResponse.ok(jsid);
    }

    @GetMapping("/er")
    public ApiResponse<String> er(){
        List<String> list = null;
        return ApiResponse.ok(list.get(0));
    }

}
