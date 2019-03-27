package springbook2.learningtest.spring.ioc;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by adaeng on 27/03/2019.
 * 스프링은 오브젝트의 생성과 관계설정 사용, 제거 등의 작업을 애필리케이션 코드 대신 독립된 컨테이너가 담당한다
 * 이게 실제 스프링에 들어가는 애플리케이션 컨텍스트 만든것임(몇가지 메소드 만 빠진모양)
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, MessageSource, ApplicationEventPublisher, ResourcePatternResolver{


}
