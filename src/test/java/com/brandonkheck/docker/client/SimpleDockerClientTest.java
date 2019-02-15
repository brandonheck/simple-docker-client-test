package com.brandonkheck.docker.client;

import java.util.List;

import org.junit.Test;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;

public class SimpleDockerClientTest {
	final String name = "";
	@Test
	public void listImages() {
		System.out.println("Docker host: " + System.getenv("DOCKER_HOST"));
		System.out.println("Docker cert path: " + System.getenv("COKER_CERT_PATH"));
		try (final DockerClient docker = DefaultDockerClient.fromEnv().build()) {
			final List<Image> images = docker.listImages(DockerClient.ListImagesParam.allImages());
		} catch (final DockerCertificateException | DockerException | InterruptedException e) {
		      throw new RuntimeException(e);
	    }
	}
}
