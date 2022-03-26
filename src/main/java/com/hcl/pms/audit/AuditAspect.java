package com.hcl.pms.audit;

import com.hcl.pms.model.AuditAction;
import com.hcl.pms.repository.AuditActionRepository;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Aspect
@Component
public class AuditAspect {
    @Autowired
    private AuditActionRepository auditActionRepository;

    private static final Logger LOG = Logger.getLogger(AuditAspect.class);

    private AuditAspect(){
    }

    @Before("execution(* com.hcl.pms.ctrl.*.*(..)) && target(request)")
    public void audit(JoinPoint joinPoint, HttpServletRequest request){

        String methodSignature = Optional.ofNullable(joinPoint.getSignature()).isPresent()
                        ? joinPoint.getSignature().getName() : null;

        String loggedUser = Optional.ofNullable(request).isPresent() ? request.getRemoteUser() : null;
        String incomingData = methodSignature + " - " + loggedUser;

        AuditAction auditAction = new AuditAction();
        auditAction.setNewData(incomingData);

        try{
            auditActionRepository.save(auditAction);
        } catch (Exception e) {
            LOG.trace("Exception happened when saving data to Audit Table ", e);
        }
    }

    /*@After(value = "execution(* com.hcl.pms.ctrl.*.*(..)) && target(response)")
    public static void audit(JoinPoint joinPoint, HttpServletResponse response){

        String methodSignature = Optional.ofNullable(joinPoint.getSignature()).isPresent()
                ? joinPoint.getSignature().getName() : null;

    }*/

}
