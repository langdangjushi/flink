/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import { Component, OnInit } from '@angular/core';
import { first, flatMap } from 'rxjs/operators';
import { JobService } from 'flink-services';

@Component({
  selector   : 'flink-job-containers',
  templateUrl: './job-containers.component.html',
  styleUrls  : [ './job-containers.component.less' ]
})
export class ContainersComponent implements OnInit {
  attempts = [];

  constructor(private jobService: JobService) {
  }

  ngOnInit() {
    this.jobService.jobDetail$.pipe(
      first(),
      flatMap(() => this.jobService.loadContainers(this.jobService.jobDetail.jid))
    ).subscribe(data => {
      this.attempts = data && data['containers'] ||  [];
      console.log(this.attempts);
      console.log(data);
    });
  }

}