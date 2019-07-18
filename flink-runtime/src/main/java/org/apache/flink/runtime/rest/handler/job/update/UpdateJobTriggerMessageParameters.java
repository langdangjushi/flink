/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.rest.handler.job.update;

import org.apache.flink.runtime.rest.messages.JobMessageParameters;
import org.apache.flink.runtime.rest.messages.JobVertexIdQueryParameter;
import org.apache.flink.runtime.rest.messages.MessageParameters;
import org.apache.flink.runtime.rest.messages.MessageQueryParameter;
import org.apache.flink.runtime.rest.messages.RescalingParallelismQueryParameter;

import java.util.Arrays;
import java.util.Collection;

/**
 * {@link MessageParameters} for triggering the rescaling of a job.
 */
public class UpdateJobTriggerMessageParameters extends JobMessageParameters {

	public final RescalingParallelismQueryParameter rescalingParallelismQueryParameter = new RescalingParallelismQueryParameter();

	public final JobVertexIdQueryParameter jobVertexIdQueryParameter = new JobVertexIdQueryParameter();

	@Override
	public Collection<MessageQueryParameter<?>> getQueryParameters() {
		return Arrays.asList(rescalingParallelismQueryParameter, jobVertexIdQueryParameter);
	}
}