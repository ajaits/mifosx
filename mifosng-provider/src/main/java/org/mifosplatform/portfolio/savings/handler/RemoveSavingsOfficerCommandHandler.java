/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.savings.handler;

import org.mifosplatform.commands.annotation.CommandType;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.portfolio.savings.service.SavingsAccountWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommandType(entity = "SAVINGSACCOUNT", action = "REMOVESAVINGSOFFICER")
public class RemoveSavingsOfficerCommandHandler implements NewCommandSourceHandler {

    private final SavingsAccountWritePlatformService savingsWritePlatformService;

    @Autowired
    public RemoveSavingsOfficerCommandHandler(final SavingsAccountWritePlatformService savingAccountWritePlatformService) {
        this.savingsWritePlatformService = savingAccountWritePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {
        return this.savingsWritePlatformService.unassignFieldOfficer(command.entityId(), command);
    }

}
