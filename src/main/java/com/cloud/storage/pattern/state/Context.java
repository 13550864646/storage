package com.cloud.storage.pattern.state;

import com.cloud.storage.base.Domain.SportsData;
import com.cloud.storage.service.ObservationService;
import com.cloud.storage.service.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个参数的封装类
 */
public class Context {
    private State state;
    private SportsData data;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ObservationService observationService;
    private PatientService patientService;

    public Context() {

    }

    /**
     * @param request
     * @param response
     * @param observationService
     * @param patientService
     */
    public Context(HttpServletRequest request, HttpServletResponse response,
                   ObservationService observationService, PatientService patientService) {
        this.request = request;
        this.response = response;
        this.observationService = observationService;
        this.patientService = patientService;
        this.state = new ReceiveState();//数据刚接收进来， 初始化为接收状态
    }

    /**
     * 数据处理
     */
    public void request() {
        state.handle(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public SportsData getData() {
        return data;
    }

    public void setData(SportsData data) {
        this.data = data;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public ObservationService getObservationService() {
        return observationService;
    }

    public void setObservationService(ObservationService observationService) {
        this.observationService = observationService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
}
