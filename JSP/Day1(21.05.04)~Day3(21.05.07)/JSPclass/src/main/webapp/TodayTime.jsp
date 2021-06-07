<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% GregorianCalendar now = new GregorianCalendar(); %>

현재일은 <%= String.format("%TY 년 %Tm월 %Td", now,now,now) %> 입니다.<br>
현재 시간은 <%= String.format("%TH 시 %TM분 %TS초", now,now,now) %> 입니다.
