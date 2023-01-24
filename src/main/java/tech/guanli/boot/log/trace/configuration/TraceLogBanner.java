package tech.guanli.boot.log.trace.configuration;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TraceLogBanner {
	@PostConstruct
	public void init() {
		StringBuilder bannerBuilder = new StringBuilder();
		bannerBuilder.append(" _____                         _             \n");
		bannerBuilder.append("|_   _| __ __ _  ___ ___      | | ___   __ _ \n");
		bannerBuilder.append("  | || '__/ _` |/ __/ _ \\_____| |/ _ \\ / _` |\n");
		bannerBuilder.append("  | || | | (_| | (_|  __/_____| | (_) | (_| |\n");
		bannerBuilder.append("  |_||_|  \\__,_|\\___\\___|     |_|\\___/ \\__, |\n");
		bannerBuilder.append("                                       |___/ ");
		bannerBuilder.append("Powered by guanli.tech");
		System.out.println(bannerBuilder.toString());
	}
}
