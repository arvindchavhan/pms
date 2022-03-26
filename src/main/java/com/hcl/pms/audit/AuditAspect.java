package com.hcl.pms.audit;

import com.hcl.pms.dto.OrderEntryDto;
import com.hcl.pms.model.AuditAction;
import com.hcl.pms.repository.AuditActionRepository;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.function.Function;

@Aspect
@Component
public class AuditAspect {
    @Autowired
    private AuditActionRepository auditActionRepository;

    private static final Logger LOG = Logger.getLogger(AuditAspect.class);

    Function<JoinPoint, String> getClassName = joinPoint -> Optional.ofNullable(joinPoint.getSignature()).isPresent()
            ? joinPoint.getSignature().getName() : null;

    private AuditAspect(){
    }

    @Before("execution(* com.hcl.pms.ctrl.*.createOrderEntry(..)) && target(request)")
    public void audit(JoinPoint joinPoint, HttpServletRequest request){

        String methodSignature = getClassName.apply(joinPoint);

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

/*    @AfterReturning(value = "execution(* com.hcl.pms.ctrl.*.createOrderEntry(..))", returning = "result")
    public void audit(JoinPoint joinPoint, Object result){

        String methodSignature = getClassName.apply(joinPoint);

        //(OrderEntryDto)result

    }*/

}
