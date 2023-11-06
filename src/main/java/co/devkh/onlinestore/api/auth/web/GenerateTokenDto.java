package co.devkh.onlinestore.api.auth.web;

import lombok.Builder;

import java.time.Duration;
import java.time.Instant;
@Builder
public record GenerateTokenDto( String auth,
                               String scope,
                               Instant expiration,
                                Duration duration,
                                Integer checkDurationValue,
                                String previousToken
                              ) {
}
