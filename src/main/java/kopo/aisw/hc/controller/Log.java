package kopo.aisw.hc.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log {

	public static void main(String[] args) {
		log.info("test");
		log.debug("오와앙");
	}
	public void logtest() {
		log.info("왜 기록이 되지 않는 것이야");
		log.debug("콘솔에는 뜨잖아!!!!!!!");
	}

}
